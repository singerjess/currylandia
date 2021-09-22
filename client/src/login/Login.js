import React from "react";
import {Block, Button, Container, Form, Heading} from 'react-bulma-components';
import { Link } from 'react-router-dom';
import {Formik} from 'formik';
import {UserApiClient} from "./service/UserApiClient";

function Login({handleLogin, handleLoginError}) {

    const userApiClient = new UserApiClient("http://localhost:8080");

    const validateForm = values => {
        const errors = {};

        if (values.mail === "") {
            errors.mail = 'Required';
        }

        if (values.password === '') {
            errors.password = 'Required';
        }
        return errors;
    };

    return <section className="is-primary is-fullheight">
        <div className="container my-5 mt-5 mx-5 px-5 is-center" style={{"maxWidth": "760px"}}>
            <h2 className="title is-2 is-strong-color">Entrá con tu usuario :)</h2>
            <Formik
                initialValues={{
                    mail: '@gmail.com',
                    password: ''
                }}
                validate={validateForm}
                onSubmit={
                    (values, actions) => {
                        try {
                            userApiClient.login(values).then(response =>
                            {handleLogin(response)})
                        } catch(error) {
                            actions.setSubmitting(false);
                            actions.setFieldError("password", "Usuario o contraseña incorrectos");
                            handleLoginError(error);
                            console.log(error);
                        };
                    }}>
                {({
                      errors, touched, handleSubmit, handleChange, values, getFieldProps, setFieldValue, isSubmitting
                  }) => (
                    <Container>
                        <Heading size="4" className="mb-3 is-strong-color">Completá los siguientes campos</Heading>

                        <form className="box" onSubmit={handleSubmit}>
                            <Form.Field>
                                <Form.Label className="is-strong-darker-color">Mail</Form.Label>
                                <Form.Control className="has-icons-left">
                                    <Form.Input type="mail" size="medium" value={values.mail} name="mail" id="mail"
                                                onChange={handleChange}
                                                placeholder="e.g. pepe@gmail.com"/>
                                    <span className="icon is-small is-left">
                                      <i className="fa fa-envelope"></i>
                                    </span>
                                </Form.Control>
                                <p className="help is-danger">{touched.mail && errors.mail}</p>
                            </Form.Field>
                            <Form.Field>
                                <Form.Label className="is-strong-darker-color">Contraseña</Form.Label>
                                <Form.Control className="has-icons-left">
                                    <Form.Input size="medium" name="password" type="password"
                                                value={values.password} id="password"
                                                onChange={handleChange}
                                                placeholder="********"/>
                                    <span className="icon is-small is-left">
                                      <i className="fa fa-lock"></i>
                                    </span>
                                </Form.Control>
                                <p className="help is-danger">{touched.password && errors.password}</p>
                            </Form.Field>
                            <Block justifyContent="flex-end" display="flex">
                                <Button.Group>
                                    <Button fullwidth color="primary" className="is-strong-darker-background-color" size="medium"
                                            disabled={isSubmitting} submit>Entrar</Button>
                                    <Button fullwidth className="is-strong-background-color" to="/register" renderAs={Link}>Registrarse</Button>
                                </Button.Group>
                            </Block>
                        </form>
                    </Container>
                )}
            </Formik>

        </div>
    </section>
}

export default Login;