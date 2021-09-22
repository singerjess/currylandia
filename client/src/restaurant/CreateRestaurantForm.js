import React from "react";
import {Block, Button, Container, Form, Heading} from 'react-bulma-components';
import {Formik} from 'formik';
import {RestaurantApiClient} from "./service/RestaurantAPIClient";

function CreateRestaurantForm() {

    const restaurantReviewApiClient = new RestaurantApiClient("http://localhost:8080");

    const validateForm = values => {
        const errors = {};

        if (values.name === "") {
            errors.name = 'Required';
        }

        if (values.address === '') {
            errors.address = 'Required';
        }

        if (values.description === '') {
            errors.description = 'Required';
        }
        return errors;
    };

    return <section className="is-primary">
        <div className="container my-5 mt-5 mx-5 px-5 is-center" style={{"maxWidth": "760px"}}>
            <h2 className="title is-1 is-capitalized is-strong-color">Creá tu Restaurante</h2>
            <Formik
                initialValues={{
                    name: '',
                    description: '',
                    address: ''
                }}
                validate={validateForm}
                onSubmit={
                    (values, actions) => {
                        restaurantReviewApiClient.createRestaurant(values)
                        .then(() => window.location.replace("/restaurantes"))
                        .catch((error) => {
                                actions.setSubmitting(false);
                                console.log(error);
                                window.location.replace("/login");
                            });
                    }}>
                {({
                      errors, touched, handleSubmit, handleChange, values, getFieldProps, setFieldValue, isSubmitting
                  }) => (
                    <Container>
                        <Heading size="4" className="mb-3 is-strong-color">Completá los siguientes campos</Heading>

                        <form onSubmit={handleSubmit}>
                            <Form.Field>
                                <Form.Label className="is-strong-darker-color" >Nombre</Form.Label>
                                <Form.Control>
                                    <Form.Input size="medium" value={values.name} name="name" id="name" onChange={handleChange}
                                                placeholder="Nombre de tu restaurante"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.name && errors.name}</p>
                            </Form.Field>
                            <Form.Field>
                                <Form.Label className="is-strong-darker-color" >Descripción</Form.Label>
                                <Form.Control>
                                    <Form.Textarea size="medium" name="description" value={values.description} id="description"
                                                   onChange={handleChange}
                                                   placeholder="Descripción de tu restaurante"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.description && errors.description}</p>
                            </Form.Field>
                            <Form.Field>
                                <Form.Label className="is-strong-darker-color" >Ubicacion</Form.Label>
                                <Form.Control>
                                    <Form.Input name="address" id="address" value={values.address}
                                                placeholder="pone una direccion y no te hagas el chistoso, betu"
                                                onChange={handleChange}
                                                size="medium"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.address && errors.address}</p>
                            </Form.Field>

                            <Block justifyContent="flex-end" display="flex">
                                <Button color="primary" className="is-strong-darker-background-color" size="medium" disabled={isSubmitting} submit>Crear</Button>
                            </Block>
                        </form>
                    </Container>
                )}
            </Formik>
        </div>
    </section>
}

export default CreateRestaurantForm;