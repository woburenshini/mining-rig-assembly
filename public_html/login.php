<?php
include('header.php');
?>

<div class = "row">
    <h1 style = "text-align:center">Login</h1>
    <div style = "width:30%; margin: 25px auto;">
        <form action="checklogin.php" method="post">
            <div class = "form-group">
                <input class = "form-control" type = "text" name = "email" placeholder = "email">
            </div>
            <div class = "form-group">
                <input class = "form-control" type = "password" name = "password" placeholder = "password">
            </div>
            <div class = "form-group">
                <button class = "btn btn-lg btn-primary btn-block">Login</button>
            </div>
        </form>
        <a href = "components.php">Go to All Components</a>
    </div>
</div>

<?php
include('footer');
?>