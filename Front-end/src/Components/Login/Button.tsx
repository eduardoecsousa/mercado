import { Button, Form } from 'antd'
import React from 'react'

interface MyComponentProps {
  func?: () => Promise<void>; // Define a propriedade func como uma função assíncrona
}


const ButtonLogin:React.FC<MyComponentProps> = ({func}) => {
  return (
    <div>
      <Form.Item label={null}>
        <Button type="primary" htmlType="submit" onClick={func}>
          Entrar
        </Button>
    </Form.Item>
    </div>
  )
}

export default React.memo(ButtonLogin)