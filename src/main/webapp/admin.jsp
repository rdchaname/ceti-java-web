<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>Admin | Proyecto CETI</title>

        <jsp:include page="plantilla/scripts-header.jsp" />
    </head>
    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <jsp:include page="plantilla/navbar.jsp" />

            <jsp:include page="plantilla/sidebar.jsp" />

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0 text-dark">Bienvenido</h1>
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
                                        <h5 class="m-0">Nombre de usuarios</h5>
                                    </div>
                                    <div class="card-body">
                                        <h6 class="card-title">has iniciado sesión</h6>
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

            <!-- Control Sidebar -->
            <jsp:include page="plantilla/sidebar-controls.jsp" />
            <!-- /.control-sidebar -->

            <!-- Main Footer -->
            <jsp:include page="plantilla/footer.jsp" />
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->
        <jsp:include page="plantilla/scripts-footer.jsp" />
    </body>
</html>
