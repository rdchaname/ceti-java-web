<%@page import="org.ceti.sistemas.proyectoceti.beans.Inscrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>Admin | Proyecto CETI</title>

        <jsp:include page="../plantilla/scripts-header.jsp" />
    </head>
    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <jsp:include page="../plantilla/navbar.jsp" />

            <jsp:include page="../plantilla/sidebar.jsp" />

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0 text-dark">Módulo de inscritos</h1>
                            </div><!-- /.col -->
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Inicio</a></li>
                                </ol>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content-header -->

                <!-- Main content -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card card-primary card-outline">
                                    <div class="card-header">
                                        <h3 class="card-title">
                                            Registrar inscrito
                                        </h3>
                                    </div>
                                    <form role="form" class="form-horizontal" id="quickForm">
                                        <div class="card-body">
                                            <div class="form-group row">
                                                <label for="apellido_paterno" class="col-sm-3 col-form-label">Apellido paterno:</label>
                                                <div class="col-sm-9 div-input">
                                                    <input type="text" class="form-control" id="apellido_paterno" name="apellido_paterno" placeholder="Apellido paterno">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="apellido_materno" class="col-sm-3 col-form-label">Apellido materno:</label>
                                                <div class="col-sm-9 div-input">
                                                    <input type="text" class="form-control" id="apellido_materno" name="apellido_materno" placeholder="Apellido apellido materno">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="nombres" class="col-sm-3 col-form-label">Nombres:</label>
                                                <div class="col-sm-9 div-input">
                                                    <input type="text" class="form-control" id="nombres" name="nombres" placeholder="Nombres">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="celular" class="col-sm-3 col-form-label">Celular:</label>
                                                <div class="col-sm-9 div-input">
                                                    <input type="text" class="form-control" id="celular" name="celular" placeholder="Celular">
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.card-body -->
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-info">Registrar</button>
                                            <a href="${url_aplicacion}/admin/inscrito" class="btn btn-default float-right">Retornar</a>
                                        </div>
                                        <!-- /.card-footer -->
                                    </form>
                                </div>
                            </div>
                            <!-- /.col-md-6 -->
                        </div>
                        <!-- /.row -->
                    </div><!-- /.container-fluid -->
                </div>
                <!-- /.content -->
            </div>
            <!-- Control Sidebar -->
            <jsp:include page="../plantilla/sidebar-controls.jsp" />
            <!-- /.control-sidebar -->

            <!-- Main Footer -->
            <jsp:include page="../plantilla/footer.jsp" />
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->
        <jsp:include page="../plantilla/scripts-footer.jsp" />

        <script type="text/javascript">
            $(document).ready(function () {
                $.validator.setDefaults({
                    submitHandler: function () {
                        alert("Form successful submitted!");
                    }
                });
                $('#quickForm').validate({
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
                            required: "Apellido paterno es requerido",
                            maxlength: "Máximo 50 carácteres"
                        },
                        celular: {
                            maxlength: "Máximo 20 carácteres"
                        },
                    },
                    errorElement: 'span',
                    errorPlacement: function (error, element) {
                        error.addClass('invalid-feedback');
                        element.closest('.div-input').append(error);
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
