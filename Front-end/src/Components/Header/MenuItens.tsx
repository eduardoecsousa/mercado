import Link from "next/link";

export const MenuItens =[
     {
      key: '1',
      label: (<Link href="/">Home</Link>),
    },
    {
      key: '2',
      label: (<Link href="/auth/login">Login</Link>),
    },
    {
      key: '3',
      label: (<Link href="/produtos">Produtos</Link>),
    },
    {
      key: '4',
      label: (<Link href="/user">Usuario</Link>),
    },
  ]
