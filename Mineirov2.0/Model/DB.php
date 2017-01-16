<?php
/**
 * Created by PhpStorm.
 * User: Me
 * Date: 06/12/2016
 * Time: 09:48
 */

namespace mineiro;


class DB
{
    var $conn ;

    public function __construct(){}

    public function conn (){

        $conn = mysqli_connect("localhost", "root", "" , "mineiro");
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        return $conn ;
    }

    function close(){
        if ($this->conn != null) mysqli_close($this->conn);
    }
}