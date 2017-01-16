<?php
/**
 * Created by PhpStorm.
 * User: Me
 * Date: 04/11/2016
 * Time: 19:07
 */

require_once 'Controllers/loadControl.php';

$cont = new \mineiro\loadControl();
require('menu.php');

$cod = $_GET['type'];

?>
    <section id="aa-product-category">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="aa-product-catg-content">
                        <div class="aa-product-catg-head">
                            <div class="aa-product-catg-head-right">
                                <a id="grid-catg" href="#"><span class="fa fa-th"></span></a>
                                <a id="list-catg" href="#"><span class="fa fa-list"></span></a>
                            </div>
                        </div>
                        <div class="aa-product-catg-body">
                            <ul class="aa-product-catg">
                                <?php
                                $cont->productLoad($cod);
                                ?>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<?php
require 'footer.php';
?>