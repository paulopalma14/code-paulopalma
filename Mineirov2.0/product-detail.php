<?php

require_once 'Controllers/loadControl.php';

$cont = new \mineiro\loadControl();
require('menu.php');

$cod = $_GET['item'];


?>
<!-- product category -->
<section id="aa-product-details">
    <div class="container">
        <div class="row">
            <?php
            $cont->productDLoad($cod);
            ?>
        </div>
    </div>
</section>
<!-- / product category -->

<?php
require 'footer.php';
?>
