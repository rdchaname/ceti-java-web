<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    String mensaje = "";
    if (sesion.getAttribute("mensaje_error") != null) {
        mensaje = (String) sesion.getAttribute("mensaje_error");
        sesion.removeAttribute("mensaje_error");
    }
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 3 | Log in</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <jsp:include page="../plantilla/scripts-header.jsp" />
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="${url_aplicacion}"><b>Java</b>WEB</a>
            </div>
            <!-- /.login-logo -->
            <div class="card">
                <div class="card-body login-card-body">
                    <%                        
                        if (mensaje != "") {
                    %>
                    <div class="alert alert-danger"><%=mensaje%></div>
                    <%        
                        }
                    %>

                    <p class="login-box-msg">Ingresa tus datos</p>

                    <form action="${url_aplicacion}/login" id="form-login" method="post">
                        <div class="input-group mb-3">
                            <input type="email" name="email" id="login" class="form-control" placeholder="Correo eletrónico">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-envelope"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" name="password" id="password" class="form-control" placeholder="Contraseña">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-8">
                                &nbsp;
                            </div>
                            <!-- /.col -->
                            <div class="col-4">
                                <button type="submit" class="btn btn-primary btn-block">Sign In</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>

                    <p class="mb-1">
                        <a href="forgot-password.html">Recuperar contraseña</a>
                    </p>
                    <p class="mb-0">
                        <a href="${url_aplicacion}/registro" class="text-center">Registrarme</a>
                    </p>
                </div>
                <!-- /.login-card-body -->
            </div>
        </div>
        <!-- /.login-box -->

        <jsp:include page="../plantilla/scripts-footer.jsp" />

        <script type="text/javascript">
            $(document).ready(function () {
                $('#form-login').validate({
                    rules: {
                        email: {
                            required: true,
                            email: true
                        },
                        password: {
                            required: true,
                        },
                    },
                    messages: {
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
