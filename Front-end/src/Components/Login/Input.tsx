import React, { Dispatch, SetStateAction } from 'react';
import { Checkbox, Form, Input } from 'antd';

type InputFormProps = {
   setUserName: (value: string) => void; 
  setPassword: (value: string) => void;
  remember?: string;
};

const InputForm: React.FC<InputFormProps> = ({setUserName, setPassword, remember}) => {

  return(
    <>
      <Form.Item
      label="userName"
      name="userName"
      rules={[{ required: true, message: 'Please input your username!' }]}
    >
      <Input onChange={(e) => setUserName(e.target.value)}/>
    </Form.Item>

    <Form.Item
      label="Password"
      name="password"
      rules={[{ required: true, message: 'Please input your password!' }]}
    >
      <Input.Password onChange={(e) => setPassword(e.target.value)}/>
    </Form.Item>

    <Form.Item<InputFormProps> name="remember" valuePropName="checked" label={null}>
      <Checkbox>Remember me</Checkbox>
    </Form.Item>
  </>
  )
}

export default InputForm;