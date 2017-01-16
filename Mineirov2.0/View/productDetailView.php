<?php
/**
 * Created by PhpStorm.
 * User: Me
 * Date: 22/12/2016
 * Time: 18:19
 */

namespace mineiro;


class productDetailView
{

    public function showDImage($result)
    {
        echo '<div class="col-md-12"><div class="aa-product-details-area">';
        echo ' <div class="aa-product-details-content">';
        echo '<div class="row">';
        echo '<div class="col-md-7 col-sm-7 col-xs-12">';
        echo '<div class="aa-product-view-content">';
        echo '<div class="col-md-5 col-sm-5 col-xs-12">';
        echo '<div class="aa-product-view-slider">';
        echo '<div id="demo-1" class="simpleLens-gallery-container">';
        echo '<div class="simpleLens-container">';
        echo '<div class="simpleLens-big-image-container">';
        echo '<img src="View/img/products/' . $result . '" class="simpleLens-big-image"></a></div>';
        echo '</div></div></div></div>';

    }

    public function showDTitlePrice($title, $price, $quantidade)
    {

        echo '<h3>' . $title . '</h3>';
        echo '<div class="aa-price-block">';
        echo '<span class="aa-product-view-price">€' . $price . '</span>';
        if (intval($quantidade) == 0) {
            echo '<p class="aa-product-avilability">Disponibilidade: <span>Produto Não Disponível</span></p>';

        } else {
            echo '<p class="aa-product-avilability">Disponibilidade: <span>Em stock</span></p>';
        }
        echo '</div>';

    }

    public function showQuanty()
    {

        echo ' <div class="aa-prod-quantity">';
        echo '<h4>Quantidade</h4>';
        echo '<form action="">';
        echo '<select id="" name="">';
        echo '<option selected="1" value="0">1</option><option value="1">2</option><option value="2">3</option>';
        echo '<option value="3">4</option><option value="4">5</option><option value="5">6</option></select></form></div>';
        echo '<div class="aa-prod-view-bottom"><a class="aa-add-to-cart-btn" href="#">Adicionar ao Carrinho</a></div></div></div>\';';


    }

    public function showDDescription($result)
    {
        echo '</div></div>';
        echo '<div class="aa-product-details-bottom">';
        echo '<ul class="nav nav-tabs" id="myTab2">';
        echo '<li><a href="#description" data-toggle="tab">Description</a></li></ul>';
        echo '<div class="tab-content"><div class="tab-pane fade in active" id="description">';
        echo '<p>' . $result . '</p>';
        echo '</div></div></div>';
    }

    public function showSizes($result)
    {
        if (intval($result) == 1) {

            echo '<h4>Tamanho</h4>';
            echo '<div class="radio aa-prod-view-size ">';
            echo '<label><input type="radio" name="name" id="inputID" value="" checked=""><a href="#">S</a></label>';
            echo '<label><input type="radio" name="name" id="inputID" value="" checked=""><a href="#">M</a></label>';
            echo '<label><input type="radio" name="name" id="inputID" value="" checked=""><a href="#">L</a></label>';
            echo '<label><input type="radio" name="name" id="inputID" value="" checked=""><a href="#">XL</a></label>';
            echo '</div>';
        }
    }

    public function showDRelated($result)
    {
        echo '<div class="aa-product-related-item">';
        echo '<h3>Produtos Relacionados</h3>';
        echo '<ul class="aa-product-catg aa-related-item-slider">';
        for ($i = 0; $i < count($result); $i++) {

            echo '<li>';
            echo '<figure>';
            echo '<a class="aa-product-img" href="product-detail.php?item='.$result[$i]["id"].'"><img src="View/img/products/' . $result[$i]["imagem"] . '" id="' . $result[$i]["id"] . '"></a>';
            echo '<a class="aa-add-card-btn" href="cart.php?item='.$result[$i]["id"].'"><span class="fa fa-shopping-cart"></span>Add To Cart</a>';
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
        echo '</ul></div></div></div>';

    }

}