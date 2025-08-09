import { Layout, Menu } from 'antd'
import { Header } from 'antd/es/layout/layout'
import React from 'react'
import { MenuItens } from './MenuItens'

export default function HeaderPrimary() {
  return (
    <div>
      <Layout>
        <Header style={{ display: 'flex', alignItems: 'center' }}>
          <div className="demo-logo" />
          <Menu
            theme="dark"
            mode="horizontal"
            defaultSelectedKeys={['2']}
            items={MenuItens}
            style={{ flex: 1, minWidth: 0 }}
          />


        </Header>
      </Layout>
    </div>
  )
}
