import HeaderPrimary from "@/Components/Header";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        
      >
        <HeaderPrimary/>
        {children}
      </body>
    </html>
  );
}
