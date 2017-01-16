<?php

/**
 * Created by PhpStorm.
 * User: Me
 * Date: 22/12/2016
 * Time: 18:47
 */

namespace mineiro;

require_once 'View/accountView.php';
require_once 'View/cartView.php';
require_once 'View/checkoutView.php';
require_once 'View/contactView.php';
require_once 'View/homeView.php';
require_once "View/productDetailView.php";
require_once "View/productView.php";
require_once "Model/CarrCompras.php";
require_once "Model/Categoria.php";
require_once "Model/Pagamento.php";
require_once "Model/Produto.php";
require_once "Model/TipoProd.php";
require_once "Model/User.php";
require_once "Model/Venda.php";

class loadControl
{
    var $accountView, $cartView, $checkoutView, $contactView, $homeView, $productDetailView, $productView;
    var $carrCompras, $categoria, $pagamento, $produto, $tipoProd, $user, $venda;

    public function __construct()
    {
        $this->accountView = new accountView();
        $this->cartView = new cartView();
        $this->checkView = new checkoutView();
        $this->contactView = new contactView();
        $this->homeView = new homeView();
        $this->productDetailView = new productDetailView();
        $this->productView = new productView();
        $this->carrCompras = new carrCompras();
        $this->categoria = new categoria();
        $this->pagamento = new pagamento();
        $this->produto = new produto();
        $this->tipoProd = new tipoProd();
        // $this->user = new user();
        $this->venda = new venda();
    }


    function accountLoad()
    {

    }

    function cartLoad()
    {

    }

    function cartQtyMenu()
    {

        $this->cartView->showQtyItems($this->carrCompras->getCarSize());

    }

    function checkLoad()
    {

    }

    function btnAddProduct($id)
    {

       $this->carrCompras->addProduct($id);

    }

    function contactLoad()
    {

    }

    function loadPopularHome()
    {

        $this->homeView->showPopular($this->produto->getPopularProduct());

    }

    function homeLoad()
    {

    }

    function productDLoad($id)
    {
        $product = $this->produto->getProduct($id);
        $this->productDetailView->showDImage($product[0]["imagem"] . "");
        $this->productDetailView->showDTitlePrice($product[0]["nome"], $product[0]["preco"], $product[0]["quantidade"]);
        $this->productDetailView->showSizes($product[0]["id_categoria"]);
        $this->productDetailView->showQuanty();
        $this->productDetailView->showDDescription($product[0]["descricao"]);
        $this->productDetailView->showDRelated($this->produto->getProductByCat($product[0]["id_categoria"]));

    }

    function productLoad($cod)
    {
        if ($cod == 0) {
            $this->productView->showProducts($this->produto->getAllProducts());
        } else {
            $this->productView->showProducts($this->produto->getProductByType($cod));
        }
    }
}