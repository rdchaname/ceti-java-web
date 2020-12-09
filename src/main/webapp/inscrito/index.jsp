<%@page import="org.ceti.sistemas.proyectoceti.beans.Inscrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ArrayList<Inscrito> listado = (ArrayList<Inscrito>) request.getAttribute("listado_inscritos");
    // Session flash
    String mensaje = "";
    if (request.getSession().getAttribute("mensaje") != null) {
        mensaje = (String) request.getSession().getAttribute("mensaje");
        request.getSession().removeAttribute("mensaje");
    }

%>
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
        <jsp:include page="../plantilla/navbar.jsp" />
        <jsp:include page="../plantilla/sidebar.jsp"/>
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
                                        Listado de inscritos
                                    </h3>
                                    <div class="card-tools">
                                        <ul class="nav nav-pills ml-auto">
                                            <li class="nav-item">
                                                <button class="btn btn-primary" data-toggle="modal" data-target="#modal-default">
                                                    <i class="fas fa-plus-circle"></i> Nuevo
                                                </button>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <table id="tabla-listado" class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Apellido paterno</th>
                                                <th>Apellido materno</th>
                                                <th>Nombres</th>
                                                <th>Celular</th>
                                                <th class="no-ordenar">Editar</th>
                                                <th class="no-ordenar">Eliminar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                                for (Inscrito inscrito : listado) {
                                            %>
                                            <tr>
                                                <td><%=inscrito.getApellido_paterno()%></td>
                                                <td><%=inscrito.getApellido_materno()%></td>
                                                <td><%=inscrito.getNombres()%></td>
                                                <td><%=inscrito.getCelular()%></td>
                                                <td>
                                                    <a href="${url_aplicacion}/admin/inscrito/editar/<%=inscrito.getId()%>" class="btn btn-warning btn-sm">Editar</a>
                                                </td>
                                                <td>
                                                    <form method="POST" action="${url_aplicacion}/admin/inscrito/eliminar/<%=inscrito.getId()%>">
                                                        <button type="submit"  onclick="return confirm('Desea eliminar el registro?')" class="btn btn-danger btn-sm">Eliminar</button>
                                                    </form>
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Apellido paterno</th>
                                                <th>Apellido materno</th>
                                                <th>Nombres</th>
                                                <th>Celular</th>
                                                <th>Editar</th>
                                                <th>Eliminar</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /.col-md-6 -->
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <div class="modal fade" id="modal-default">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Registrar persona</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form class="form-horizontal" id="modal-registro" method="POST" action="${url_aplicacion}/admin/inscrito/crear">
                        <div class="modal-body">
                            <div class="form-group row">
                                <label for="apellido_paterno" class="col-sm-3 col-form-label">Apellido paterno:</label>
                                <div class="col-sm-9 div-input">
                                    <input type="text" class="form-control" id="apellido_paterno" name="apellido_paterno" placeholder="Apellido paterno">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="apellido_materno" class="col-sm-3 col-form-label">Apellido materno:</label>
                                <div class="col-sm-9 div-input">
                                    <input type="text" class="form-control" id="apellido_materno" name="apellido_materno" placeholder="Apellido materno">
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
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Crear</button>
                        </div>
                    </form>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- Control Sidebar -->
        <jsp:include page="../plantilla/sidebar-controls.jsp" />
        <!-- /.control-sidebar -->

        <!-- Main Footer -->
        <jsp:include page="../plantilla/footer.jsp" />

        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->
        <jsp:include page="../plantilla/scripts-footer.jsp" />

        <script>
            $(document).ready(function () {
            <%if (!mensaje.isEmpty()) {%>
                toastr.options = {
                    "timeOut": "2000"
                }
                toastr.success('<%=mensaje%>');
            <%}%>

                $('#tabla-listado').DataTable({
                    "paging": true,
                    "lengthChange": false,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": false,
                    "responsive": true,
                    "language": {
                        url: "https://cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
                    },
                    "columnDefs": [
                        {
                            orderable: false,
                            targets: "no-ordenar"
                        }
                    ]
                });
                $.validator.setDefaults({
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
                $('#modal-registro').validate({
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
