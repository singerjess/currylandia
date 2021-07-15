import React from "react";
import {Block, Button, Container, Form, Heading} from 'react-bulma-components';
import {Formik} from 'formik';
import {RestaurantApiClient} from "./service/RestaurantAPIClient";

function CreateRestaurantForm() {

    const restaurantReviewApiClient = new RestaurantApiClient("http://localhost:8080");

    const daysOfWeek = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"];
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
            <h2 className="title is-1 is-capitalized">Creá tu Restaurante</h2>
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
                            .catch((error) => {
                                actions.setSubmitting(false);
                                console.log(error);
                            });
                        actions.resetForm({
                            values: {
                                // the type of `values` inferred to be Blog
                                name: '',
                                description: '',
                                address: '',
                            }
                        });
                    }}>
                {({
                      errors, touched, handleSubmit, handleChange, values, getFieldProps, setFieldValue, isSubmitting
                  }) => (
                    <Container>
                        <Heading size="4" className="mb-3">Completá los siguientes campos</Heading>

                        <form onSubmit={handleSubmit}>
                            <Form.Field>
                                <Form.Label>Nombre</Form.Label>
                                <Form.Control>
                                    <Form.Input size="medium" value={values.name} name="name" id="name" onChange={handleChange}
                                                placeholder="Nombre de tu restaurante"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.name && errors.name}</p>
                            </Form.Field>
                            <Form.Field>
                                <Form.Label>Descripción</Form.Label>
                                <Form.Control>
                                    <Form.Textarea size="medium" name="description" value={values.description} id="description"
                                                   onChange={handleChange}
                                                   placeholder="Descripción de tu restaurante"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.description && errors.description}</p>
                            </Form.Field>

                            {/*<Form.Label>Horarios</Form.Label>*/}
                            {/*{daysOfWeek.map((day, index) =>*/}
                            {/*<Form.Field key={day} className="has-addons">*/}
                            {/*    <Form.Label style={{minWidth: "150px"}}>*/}
                            {/*        <Button style={{minWidth: "150px"}} className="is-static" size="medium">{day}</Button>*/}
                            {/*    </Form.Label>*/}
                            {/*    <Form.Control className="is-expanded">*/}
                            {/*        <Form.Input name={`schedule_${index}`} placeholder={`Horario día ${day}`} id={`schedule_${index}`} size="medium" />*/}
                            {/*    </Form.Control>*/}
                            {/*    <p className="help is-danger">{touched.schedule && errors.schedule}</p>*/}
                            {/*</Form.Field>*/}
                            {/*)}*/}
                            <Form.Field>
                                <Form.Label>Ubicacion</Form.Label>
                                <Form.Control>
                                    <Form.Input name="address" id="address" value={values.address}
                                                placeholder="pone una direccion y no te hagas el chistoso, betu"
                                                onChange={handleChange}
                                                size="medium"/>
                                </Form.Control>
                                <p className="help is-danger">{touched.address && errors.address}</p>
                            </Form.Field>

                            <Block justifyContent="flex-end" display="flex">
                                <Button color="primary" size="medium" disabled={isSubmitting} submit>Crear</Button>
                            </Block>
                        </form>
                    </Container>
                )}
            </Formik>
        </div>
    </section>
}

export default CreateRestaurantForm;