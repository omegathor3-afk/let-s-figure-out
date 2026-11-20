# AutoEarn

Arabic-first Android companion for managing legitimate passive-income services.

## Current MVP
- Native Android / Kotlin / Jetpack Compose app.
- Arabic onboarding screen for Honeygain.
- Explicit disclosure of bandwidth sharing, IP routing, payout thresholds, and network risks.
- No fake earnings, fake steps, ad clicks, survey automation, or bypassing third-party app rules.

## Important limitations
AutoEarn is a companion, not a Honeygain client. It does not embed Honeygain, control its account, read its private balance, or guarantee earnings. Honeygain must be installed and configured separately by the device owner. Android does not let an ordinary app silently control another app's private functions.

Honeygain's current published payout details:
- Honeygain mode: $20 minimum, PayPal.
- JumpTask mode: $1 first payout, then $0.50; gift-card options depend on country and are handled through GIFQ.
- Vodafone Cash is not listed as a direct payout method.
- Earnings depend on actual demand for the user's IP and bandwidth; there is no guaranteed daily income.

Review the official terms before enabling bandwidth sharing. Honeygain warns that internet-provider terms, mobile data charges, and network usage can affect the user.

## Build
GitHub Actions builds a debug APK on pushes to main and manual workflow dispatch.
