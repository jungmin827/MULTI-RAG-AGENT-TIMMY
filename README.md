# Client-Aware Email Assistant
> 관계 맥락을 기억하는 Gmail 기반 AI 이메일 작성 서비스

## 프로젝트 구조

```
MULTI-RAG-AGENT-TIMMY/
├── backend/              # Spring Boot + Kotlin + langchain4j
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/com/emailassistant/
│   │       │   ├── controller/    # REST API 컨트롤러
│   │       │   ├── service/       # 비즈니스 로직
│   │       │   ├── ai/            # langchain4j AI 레이어
│   │       │   ├── domain/        # 엔티티 모델
│   │       │   ├── repository/    # 데이터 접근 계층
│   │       │   └── config/        # 설정 클래스
│   │       └── resources/
│   │           └── application.yml
│   └── build.gradle.kts
│
└── frontend/            # Next.js + TypeScript + Tailwind CSS
    ├── app/             # Next.js App Router
    │   ├── mails/       # 메일 목록 페이지
    │   └── drafts/      # 초안 관리 페이지
    ├── components/      # React 컴포넌트
    ├── services/        # API 호출 서비스
    └── package.json
```

## 기술 스택

### Backend
- Kotlin
- Spring Boot 3.2.0
- langchain4j 0.25.0
- PostgreSQL
- Redis

### Frontend
- Next.js 14
- TypeScript
- Tailwind CSS

## 시작하기

### Backend 실행
```bash
cd backend
./gradlew bootRun
```

### Frontend 실행
```bash
cd frontend
npm install
npm run dev
```

## 환경 변수 설정

### Backend (.env 또는 application.yml)
- `DB_USERNAME`: PostgreSQL 사용자명
- `DB_PASSWORD`: PostgreSQL 비밀번호
- `REDIS_HOST`: Redis 호스트
- `REDIS_PORT`: Redis 포트
- `OPENAI_API_KEY`: OpenAI API 키
- `GMAIL_CLIENT_ID`: Gmail OAuth 클라이언트 ID
- `GMAIL_CLIENT_SECRET`: Gmail OAuth 클라이언트 시크릿

### Frontend (.env.local)
- `NEXT_PUBLIC_API_URL`: Backend API URL (기본값: http://localhost:8080/api)
