<?php

/**
 * Created by PhpStorm.
 * User: Me
 * Date: 14/11/2016
 * Time: 14:23
 */

namespace mineiro ;

require_once 'DB.php' ;


class Produto
{

    var $conn ;

    function __construct() {

        $this->conn = new DB();

    }

    function getAllProducts(){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;

        $query = 'SELECT * FROM produto';

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;

    }

    function getPopularProduct(){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;

        $query = 'SELECT * FROM produto limit 10' ;

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;

    }

    function getProductByCat($cat){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;

        $query = 'SELECT * FROM produto WHERE produto.id_categoria = '.$cat;

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;

    }

    function getProduct($id){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;
        $query = 'SELECT * FROM produto WHERE produto.id = '.$id;

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;

    }

    function getProductByType($type){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;

        $query = 'SELECT * FROM produto WHERE produto.id_tipo_produto = '.$type ;

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;


    }

    function getProductbyName($name){

        $conn = $this->conn->conn();
        $result = array();
        $i = 0;

        $query = 'SELECT * FROM produto WHERE produto.nome = %'.$name.'%';

        $sql = mysqli_query($conn, $query) or trigger_error($conn->error);

        while ($row = mysqli_fetch_array($sql)) {
            $result[$i]['id'] = $row['id'];
            $result[$i]['nome'] = $row['nome'];
            $result[$i]['marca'] = $row['marca'];
            $result[$i]['preco'] = $row['preco'];
            $result[$i]['quantidade'] = $row['quantidade'];
            $result[$i]['imagem'] = $row['imagem'];
            $result[$i]['descricao'] = $row['descricao'];
            $result[$i]['id_categoria'] = $row['id_categoria'];
            $i++;
        }

        return $result;

    }

}