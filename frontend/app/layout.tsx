import type { Metadata } from 'next'
import './globals.css'

export const metadata: Metadata = {
  title: 'Email Assistant',
  description: '클라이언트별로 어떻게 말해야 하는지를 기억해주는 Gmail AI 어시스턴트',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="ko">
      <body>{children}</body>
    </html>
  )
}

