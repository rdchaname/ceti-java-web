<%@page import="org.ceti.sistemas.proyectoceti.beans.Usuario"%>
<%
    String menu_activo = (request.getAttribute("menu_activo") != null) ? (String) request.getAttribute("menu_activo") : "";
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String[][] menu_usuario = (String[][]) session.getAttribute("menu_usuario");
%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="${url_aplicacion}/admin" class="brand-link">
        <img src="${url_aplicacion}/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Java web</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="${url_aplicacion}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block"><%=usuario.getInscrito().getNombres() + " " + usuario.getInscrito().getApellido_paterno()%></a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <%
                    for (String[] menu : menu_usuario) {
                        String activo = (menu[0].equals(menu_activo)) ? "active" : "";
                %>
                <li class="nav-item">
                    <a href="${url_aplicacion}/<%=menu[0]%>" class="nav-link <%=activo%>">
                        <i class="nav-icon fas fa-th"></i>
                        <p>
                            <%=menu[1]%>
                        </p>
                    </a>
                </li>
                <%                    }
                %>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
