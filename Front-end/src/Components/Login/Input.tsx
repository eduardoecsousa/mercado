import React, { Dispatch, SetStateAction } from 'react';
import { Checkbox, Form, Input } from 'antd';

type FieldType = {
  setEmail: Dispatch<SetStateAction<string>>;
  setPassword: Dispatch<SetStateAction<string>>;
  remember?: string;
};

const InputForm: React.FC<FieldType> = ({setEmail, setPassword}) => {
  return(
    <>
      <Form.Item
      label="email"
      name="email"
      rules={[{ required: true, message: 'Please input your username!' }]}
    >
      <Input onChange={(e) => setEmail(e.target.value)}/>
    </Form.Item>

    <Form.Item
      label="Password"
      name="password"
      rules={[{ required: true, message: 'Please input your password!' }]}
    >
      <Input.Password onChange={(e) => setPassword(e.target.value)}/>
    </Form.Item>

    <Form.Item<FieldType> name="remember" valuePropName="checked" label={null}>
      <Checkbox>Remember me</Checkbox>
    </Form.Item>
  </>
  )
}

export default InputForm;