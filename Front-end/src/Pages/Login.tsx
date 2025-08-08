'use client'; // 👈 Adicione isso na primeira linha do arquivo
import InputForm from "@/Components/Login/Input";
import React, { useState } from "react";
import ButtonLogin from '../Components/Login/Button'
import { Form, FormProps, Row } from "antd";
import UserService from "@/Services/UserService";

type FieldType = {
  username?: string;
  password?: string;
  remember?: string;
};

const Login: React.FC = () => {
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const [message, setMessage] = useState("")

  const handleLogin = async () => {
    try {
      const result = await UserService
      setMessage("Login realizado com sucesso!")
      console.log(result)
    } catch (error) {
        setMessage(error.message)
    }
  }

  return (
    <>
      <Row
        justify="center"          
        align="middle"            
        style={{ height: "100vh" }} 
      >
        <Form
          name="basic"
          labelCol={{ span: 8 }}
          wrapperCol={{ span: 16 }}
          style={{ maxWidth: 600 }}
          initialValues={{ remember: true }}
          autoComplete="off"
        >
          <InputForm setEmail={setEmail} setPassword={setPassword}/>
          <ButtonLogin func={handleLogin}/>
        </Form>
      </Row>
    </>
  );
};

export default React.memo(Login);


