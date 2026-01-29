# Client-Aware Email Assistant
> 관계 맥락을 기억하는 Gmail 기반 AI 이메일 작성 서비스

---

## 1. 프로젝트 개요

### 1.1 문제 정의
클라이언트를 상대하는 사람들은 매일 많은 비즈니스 이메일을 작성한다.
문제는 **글을 쓰는 것 자체가 아니라**, 다음을 매번 판단해야 한다는 점이다.

- 이 사람에게는 어떤 톤이 맞는지
- 이전에 어떤 이야기를 했는지
- 관계를 해치지 않으면서 내 의도를 전달하는 방식은 무엇인지

이 모든 맥락을 **매번 사용자가 설명하는 것은 매우 번거롭다.**

---

### 1.2 해결책
본 서비스는 Gmail과 연동되어,
**상대방(클라이언트)별 커뮤니케이션 컨텍스트를 기억하고**
사용자는 단순히 “의도”만 입력하면
AI가 맞춤형 이메일 본문을 생성해주는 서비스다.

---

### 1.3 핵심 가치 제안 (Value Proposition)

- 관계 맥락을 기억하는 AI
- 상황 설명이 필요 없는 이메일 생성
- 선택 기반 학습을 통한 개인화
- 자동 전송이 아닌 **승인 후 전송**으로 신뢰 확보

---

## 2. 타겟 사용자

### 2.1 타겟 정의
- 클라이언트를 상대해야 하는 직군
  - 프리랜서
  - 에이전시
  - 영업 / BD
  - 스타트업 대표
  - 컨설턴트

### 2.2 사용자 특성
- 하루 이메일 빈도 높음
- 관계 리스크에 민감
- 생산성 도구에 비용 지불 의사 있음

---

## 3. 제품 UX 흐름

### 3.1 온보딩
사용자는 최초 1회 다음 정보를 입력한다.

#### 사용자 프로필
- 직업 / 역할
- 산업군
- 주요 클라이언트 유형
- 기본 커뮤니케이션 톤
- 관계 성향 (갈등 회피 / 직설적 등)

이 정보는 장기 메모리로 유지된다.

---

### 3.2 메일 응답 플로우

1. Gmail에 메일 수신
2. 서비스에서 메일 목록 표시
3. 메일 선택
4. 사용자는 **의도만 입력**
   - 예: "일정 1주 미루고 싶고 관계 유지"
5. AI가 다음을 생성
   - 상황 요약
   - 리스크 포인트
   - 이메일 본문 3안
6. 사용자는 하나 선택
7. 전송 버튼 클릭 → Gmail 전송

---

## 4. 기술 스택

### 4.1 Frontend
- Next.js (React)
- TypeScript
- Tailwind CSS

### 4.2 Backend
- Kotlin
- Spring Boot
- langchain4j

### 4.3 External
- Gmail REST API
- OAuth2 (Google)

### 4.4 Infra
- PostgreSQL (유저/관계/컨텍스트 저장)
- Redis (세션/캐시)

---

## 5. 시스템 아키텍처

[Next.js Frontend]
|
v
[Spring Boot API]
|
v
[AI Layer - langchain4j]
|
v
[Memory / Context Store]
|
v
[Gmail REST API]


---

## 6. AI 설계 (langchain4j)

### 6.1 AI 역할 정의
AI는 단순 텍스트 생성기가 아니라,
**비즈니스 커뮤니케이션 어시스턴트**다.

---

### 6.2 메모리 구조

#### User Memory
- 사용자 프로필
- 기본 톤
- 의사결정 성향

#### Client Memory
- 클라이언트별 톤
- 이전 메일 요약
- 민감 포인트
- 관계 온도

---

### 6.3 AI Service 인터페이스 예시

```kotlin
@AiService
interface EmailAssistant {

    @SystemMessage("""
    You are a professional business email assistant.
    You must consider the user's profile and the client's context.
    Always generate 3 alternatives with different tones.
    """)
    fun generateReply(
        @UserMessage intent: String,
        @MemoryId clientId: String
    ): List<EmailDraft>
}

### 6.4 Prompt 전략

시스템 메시지에 역할과 기준 고정

유저 메시지는 의도만 받음

메모리는 자동 주입

### 7. Backend 구조

/controller
  - MailController
/service
  - MailService
  - DraftService
  - GmailService
/ai
  - EmailAssistant
  - PromptTemplates
/domain
  - User
  - Client
  - MailContext
/repository
  - UserRepository
  - ClientRepository

### 8. Frontend 구조

/app
  /mails
  /drafts
/components
  - MailList
  - IntentInput
  - DraftSelector
  - RiskSummary
/services
  - api.ts

### 9. MVP 범위
#### 9.1 포함

Gmail 연동

클라이언트별 컨텍스트 저장

의도 기반 본문 생성

본문 선택 후 전송

#### 9.2 제외 (추후)

자동 전송

모바일 앱

CRM 연동

팀 기능

### 10. 성공 기준 (MVP)

사용자가 두 번째 메일부터 설명을 거의 하지 않음

“이거 없으면 메일 못 쓰겠다” 피드백

하루 최소 3회 이상 사용

### 11. 제품 한 문장 설명

“클라이언트별로 어떻게 말해야 하는지를 기억해주는 Gmail AI 어시스턴트”


---

이제 이 마크다운 파일을 그대로:

- `PROJECT_OVERVIEW.md`
- 또는 `README.md`

로 만들어서  
👉 **Cursor 에이전트에게 “이 문서 기준으로 개발 시작”** 시키면 된다.

---

### 다음으로 추천하는 액션 (아주 중요)

1️⃣ 이 문서를 Cursor에 넣고  
👉 “**이 프로젝트의 백엔드 기본 골격을 생성해줘**”

2️⃣ 또는  
👉 “**langchain4j 기반 AI 레이어부터 구현해줘**”

원하면  
- **프롬프트 템플릿 전용 문서**
- **Cursor용 시스템 프롬프트**
- **MVP 개발 순서 체크리스트**

까지도 바로 만들어줄게.

이제 진짜 시작이다 🚀
::contentReference[oaicite:0]{index=0}
