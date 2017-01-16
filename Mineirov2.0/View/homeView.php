<?php
/**
 * Created by PhpStorm.
 * User: Me
 * Date: 22/12/2016
 * Time: 18:19
 */

namespace mineiro;

require_once 'Controllers/loadControl.php';

class homeView
{

    public function __construct()
    {

    }


    public function showPopular($result)
    {

        for ($i = 0; $i < count($result); $i++) {

            echo '<li>';
            echo '<figure>';
            echo '<a class="aa-product-img" href="product-detail.php?item='.$result[$i]["id"].'"><img src="View/img/products/' . $result[$i]["imagem"] . '" id="' . $result[$i]["id"] . '"></a>';
            echo '<a class="aa-add-card-btn" href="cart.php?prod='.$result[$i]["id"].'"><span class="fa fa-shopping-cart"></span>Add To Cart</a>';
            echo '<figcaption>';
            echo '<h4 class="aa-product-title"><a href="#">' . $result[$i]["nome"] . '</a></h4>';
            echo '<span class="aa-product-price">€' . $result[$i]["preco"] . '</span>';
            echo '</figcaption>';
            echo '</figure>';
            if (intval($result[$i]['quantidade']) == 0) {

                echo '<span class="aa-badge aa-sold-out" href="#">Sold Out!</span>';
            }
            echo '</li>';

        }
    }

}