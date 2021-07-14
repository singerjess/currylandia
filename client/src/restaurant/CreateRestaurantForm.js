import React from "react";
import {Block, Button, Container, Form, Heading} from 'react-bulma-components';
import {Formik} from 'formik';

function CreateRestaurantForm(){
    const daysOfWeek = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"];
    const validateForm = values => {
        const errors = {};

        if (values.name === "") {
            errors.name = 'Required';
        }

        if (values.location === '') {
            errors.location = 'Required';
        }
        return errors;
    }

    return <section className="is-primary">
        <div className="container my-5 mt-5 mx-5 px-5 is-center" style={{"maxWidth":"760px"}}>
            <h2 className="title is-1 is-capitalized">Creá tu Restaurante</h2>
            <Formik
                initialValues={{
                    name: "",
                    location:"",
                    schedule_0: "",
                    schedule_1: "",
                    schedule_2: "",
                    schedule_3: "",
                    schedule_4: "",
                    schedule_5: "",
                    schedule_6: "",
                    schedule_7: ""
                }}
                validate={validateForm}
                onSubmit={(values, {setSubmitting}) => {
                    // same shape as initial values
                    alert(values.toString());
                }}>
                {({
                      errors, touched, handleSubmit, values, getFieldProps, setFieldValue, isSubmitting
                  }) => (
                    <Container>
                        <Heading size="4" className="mb-3">Completá los siguientes campos</Heading>

                        <form onSubmit={handleSubmit}>
                            <Form.Field>
                                <Form.Label>Nombre</Form.Label>
                                <Form.Control>
                                    <Form.Input size="medium" name="name" id="name" onChange={name => setFieldValue("name", name)} placeholder="Nombre de tu restaurante" />
                                </Form.Control>
                                <p className="help is-danger">{touched.name && errors.name}</p>
                            </Form.Field>

                            <Form.Label>Horarios</Form.Label>
                            {daysOfWeek.map((day, index) =>
                            <Form.Field key={day} className="has-addons">
                                <Form.Label style={{minWidth: "150px"}}>
                                    <Button style={{minWidth: "150px"}} className="is-static" size="medium">{day}</Button>
                                </Form.Label>
                                <Form.Control className="is-expanded">
                                    <Form.Input name={`schedule_${index}`} placeholder={`Horario día ${day}`} id={`schedule_${index}`} size="medium" />
                                </Form.Control>
                                <p className="help is-danger">{touched.schedule && errors.schedule}</p>
                            </Form.Field>
                            )}
                            <Form.Field>
                                <Form.Label>Ubicacion</Form.Label>
                                <Form.Control>
                                    <Form.Input name="location" id="location" placeholder="pone una direccion y no te hagas el chistoso, betu" onChange={location => setFieldValue("location", location)} size="medium" />
                                </Form.Control>
                                <p className="help is-danger">{touched.location && errors.location}</p>
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