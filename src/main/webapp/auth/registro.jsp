<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    String mensaje_error = "";
    if (sesion.getAttribute("mensaje_error") != null) {
        mensaje_error = (String) request.getAttribute("mensaje_error");
        sesion.removeAttribute("mensaje_error");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 3 | Registration Page</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <jsp:include page="../plantilla/scripts-header.jsp" />
    </head>
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="register-logo">
                <a href="${url_aplicacion}"><b>Java</b>WEB</a>
            </div>

            <div class="card">
                <div class="card-body register-card-body">
                    <%
                        if (mensaje_error != "") {
                    %>
                    <div class="alert alert-danger"><%=mensaje_error%></div>
                    <%
                        }
                    %>

                    <p class="login-box-msg">Ingresar sus datos</p>

                    <form action="${url_aplicacion}/registro" method="post" id="form-registro">
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="apellido_paterno" id="apellido_paterno" placeholder="Apellido paterno">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-user"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="apellido_materno" id="apellido_materno" placeholder="Apellido materno">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-user"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="nombres" id="nombres" placeholder="Nombres">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-user"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="celular" id="celular" placeholder="Celular">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-user"></span>
                                </div>
                            </div>
                        </div>

                        <div class="input-group mb-3">
                            <input type="email" class="form-control" name="email" idemail" placeholder="Correo electrónico">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-envelope"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Contraseña">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <a href="${url_aplicacion}/login" class="btn btn-outline-info btn-block">Ingresar</a>
                            </div>
                            <!-- /.col -->
                            <div class="col-6">
                                <button type="submit" id="btn-registrar" class="btn btn-primary btn-block">Registrarse</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>

                </div>
                <!-- /.form-box -->
            </div><!-- /.card -->
        </div>
        <!-- /.register-box -->

        <jsp:include page="../plantilla/scripts-footer.jsp" />

        <script type="text/javascript">
            $(document).ready(function () {
                $('#form-registro').validate({
                    submitHandler: function (form) {
                        $('#btn-registrar').addClass("disabled");
                        setTimeout(function () {
                            form.submit();
                        }, 3000)

                    },
                    rules: {
                        apellido_paterno: {
                            required: true,
                            maxlength: 50
                        },
                        apellido_materno: {
                            required: true,
                            maxlength: 50
                        },
                        nombres: {
                            required: true,
                            maxlength: 50
                        },
                        celular: {
                            required: false,
                            maxlength: 20
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        password: {
                            required: true,
                        },
                    },
                    messages: {
                        apellido_paterno: {
                            required: "Apellido paterno es requerido",
                            maxlength: "Máximo 50 carácteres"
                        },
                        apellido_materno: {
                            required: "Apellido paterno es requerido",
                            maxlength: "Máximo 50 carácteres"
                        },
                        nombres: {
                            required: "Nombre es requerido",
                            maxlength: "Máximo 50 carácteres"
                        },
                        celular: {
                            maxlength: "Máximo 20 carácteres"
                        },
                        email: {
                            required: "Correo electrónico es requerido",
                            email: "Correo inválido"
                        },
                        password: {
                            required: "Contraseña requerida",
                        },
                    },
                    errorElement: 'span',
                    errorPlacement: function (error, element) {
                        error.addClass('invalid-feedback');
                        element.closest('.input-group').append(error);
                    },
                    highlight: function (element, errorClass, validClass) {
                        $(element).addClass('is-invalid');
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).removeClass('is-invalid');
                    }
                });
            });
        </script>
    </body>
</html>
