export interface User {
  id: number
  email: string
  role?: string
  industry?: string
  clientType?: string
  defaultTone?: string
  relationshipStyle?: string
}

export interface Client {
  id: number
  userId: number
  email: string
  name?: string
  tone?: string
  previousMailSummary?: string
  sensitivePoints?: string
  relationshipTemperature?: string
}

export interface MailContext {
  id: number
  userId: number
  clientId: number
  gmailMessageId: string
  subject?: string
  body?: string
  intent?: string
  selectedDraft?: string
}

export interface EmailDraft {
  content: string
  tone: string
  riskPoints: string[]
}

