<?php

/**
 * Created by PhpStorm.
 * User: Me
 * Date: 14/11/2016
 * Time: 14:23
 */

namespace mineiro;

class User
{
    var $nome, $ultimo, $morada, $nif, $email, $pass, $contacto, $data_nas, $cidade, $cod_postal, $distrito, $pais;

    public function __construct($nome, $ultimo, $morada, $nif, $email, $pass, $contacto, $data_nas, $cidade, $cod_postal, $distrito, $pais)
    {
        $this->nome = $nome ;
        $this->ultimo = $ultimo;
        $this->morada = $morada;
        $this->nif = $nif ;
        $this->email = $email;
        $this->pass = $pass;
        $this->contacto = $contacto;
        $this->data_nas = $data_nas;
        $this->cidade = $cidade;
        $this->cod_postal = $cod_postal;
        $this->distrito = $distrito;
        $this->pais = $pais;

    }

    public function registerUser()
    {





    }

    public function getUser($id)
    {

    }

}