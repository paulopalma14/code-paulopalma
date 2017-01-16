<?php

/**
 * Created by PhpStorm.
 * User: Me
 * Date: 14/11/2016
 * Time: 16:17
 */

namespace mineiro;

class CarrCompras
{

    private $car;
    private $venda;
    private $produto;

    function __construct()
    {

        $this->car = array();
        $this->venda = new Venda();
        $this->produto = new Produto();

    }

    function addVenda()
    {

        $this->venda->setPaymentMethod();
        $this->venda->sendToDB();
        $this->venda->sendEmail();

    }

    function addProduct($id)
    {

        $this->car[count($this->car)] = $this->produto->getProduct($id);

    }

    function removeProduct($id)
    {
        if ($id >= 0 || $id < count($this->car)) {
            unset($this->car[$id]);
        }
    }

    function getCarSize()
    {

        return count($this->car);

    }

    function resetCar()
    {

        unset($this->car);
        $this->car = array();

    }

}