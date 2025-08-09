'use client'; // 👈 Adicione isso na primeira linha do arquivo
import InputForm from "@/Components/Login/Input";
import React, { useState } from "react";
import ButtonLogin from '../../Components/Login/Button'
import { Form, Row } from "antd";
import { loginService } from "@/Services/Login/Login.service";
import { ILogin } from "@/Interfaces/ILogin";
import { useRouter } from "next/navigation";


const Login: React.FC = () => {
  const [userName, setIsUserName] = useState<string>()
  const [password, setIsPassword] = useState<string>()
  const [message, setIsMessage] = useState<string>()
  const [form] = Form.useForm();
  const router = useRouter();


  const handleLogin = async () => {
    try {
      const loginElements: ILogin = { userName, password };
      const result = await loginService(loginElements);
      
      // Feedback visual melhor que alert
      setIsMessage('Login realizado com sucesso!');
      
      // Redireciona após o login
      router.push('/');
      
      console.log(result);
    } catch (err) {
      setIsMessage(`Falha ao fazer o Login: ${err instanceof Error ? err.message : String(err)}`);
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
          name="login"
          form={form}
          labelCol={{ span: 8 }}
          wrapperCol={{ span: 16 }}
          style={{ maxWidth: 600 }}
          initialValues={{ remember: true }}
          autoComplete="off"
        >
          <InputForm setUserName={setIsUserName} setPassword={setIsPassword}/>
          <ButtonLogin func={handleLogin}/>
        </Form> 
      </Row>
    </>
  );
};

export default React.memo(Login);


