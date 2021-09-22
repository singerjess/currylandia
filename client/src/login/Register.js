import React from "react";
import {Block, Button, Container, Form, Heading} from 'react-bulma-components';
import { Link } from 'react-router-dom';
import {Formik} from 'formik';
import {UserApiClient} from "./service/UserApiClient";

function Register({handleRegistration, handleRegistrationError}) {

    const validateForm = values => {
        const errors = {};

        if (values.name === "") {
            errors.name = 'Required';
        }

        if (values.mail === '') {
            errors.mail = 'Required';
        }

        if (values.password === '') {
            errors.password = 'Required';
        }
        return errors;
    };
    const userApiClient = new UserApiClient("http://localhost:8080");
    return <section className="is-primary is-fullheight">
        <div className="container my-5 mt-5 mx-5 px-5 is-center" style={{"maxWidth": "760px"}}>
            <h2 className="title is-2 is-strong-color">Registrate y cargá tu restorán</h2>
            <Formik
                initialValues={{
                    mail: '@gmail.com',
                    username: '',
                    password: ''
                }}
                validate={validateForm}
                onSubmit={
                    (values, actions) => {
                        let response;
                        response = userApiClient.register(values)
                        handleRegistration(response)
                            .catch(error => {
                                actions.setSubmitting(false);
                                actions.setFieldError("password", "Usuario o contraseña incorrectos");
                                handleRegistrationError(error);
                                console.log(error);
                            });
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
                                <Form.Label className="is-strong-darker-color">Nombre de Usuario</Form.Label>
                                <Form.Control className="has-icons-left">
                                    <Form.Input type="text" size="medium" value={values.username} name="username" id="username"
                                                onChange={handleChange}
                                                placeholder="e.g. jesskpa123"/>
                                    <span className="icon is-small is-left">
                                      <i className="fa fa-user"></i>
                                    </span>
                                </Form.Control>
                                <p className="help is-danger">{touched.username && errors.username}</p>
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
                                    <Button fullwidth size="medium" className="is-strong-background-color" renderAs={Link}  to="/login" submit>Registrar</Button>
                                </Button.Group>
                            </Block>
                        </form>
                    </Container>
                )}
            </Formik>

        </div>
    </section>
}
export default Register;