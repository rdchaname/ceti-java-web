<%@page import="org.ceti.sistemas.proyectoceti.beans.Inscrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Inscrito> listado = (ArrayList<Inscrito>) request.getAttribute("listado_inscritos");
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
                                                <%
                                                    for (Inscrito inscrito : listado) {
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
                                                        <button class="btn btn-danger btn-sm">Eliminar</button>
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
                        <form class="form-horizontal">
                            <div class="modal-body">
                                <div class="form-group row">
                                    <label for="apellido_paterno" class="col-sm-3 col-form-label">Apellido paterno:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="apellido_paterno" placeholder="Apellido paterno">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="apellido_materno" class="col-sm-3 col-form-label">Apellido materno:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="apellido_materno" placeholder="Apellido apellido materno">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="nombres" class="col-sm-3 col-form-label">Nombres:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="nombres" placeholder="Nombres">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="celular" class="col-sm-3 col-form-label">Celular:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="celular" placeholder="Celular">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
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
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->
        <jsp:include page="../plantilla/scripts-footer.jsp" />

        <script>
            $(function () {
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
            });
        </script>
    </body>
</html>
