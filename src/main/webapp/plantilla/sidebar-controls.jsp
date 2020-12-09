<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
        <h5>Opciones</h5>
        <p>
            <a class="btn btn-link" role="link" href="${url_aplicacion}/"><i class="fas fa-home"></i> Ir al inicio</a>
        </p>
        <p>
        <form action="${url_aplicacion}/logout" method="POST">
            <button class="btn btn-link text-white" role="link" type="submit" onclick="window.location.replace('${url_aplicacion}/login');return true;"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</button>
        </form>
        </p>
    </div>
</aside>