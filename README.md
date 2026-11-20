# AUTOEARN

Arabic-first Android companion for starting and keeping legitimate earning services configured.

## Current functionality
- Native Android / Kotlin / Jetpack Compose app.
- Honeycomb-inspired dark/gold Arabic UI.
- Detects whether the Honeygain Android package is installed.
- Opens the installed Honeygain app directly; falls back to Honeygain's official download page if absent.
- Opens Android's App info page for Honeygain so the device owner can configure battery/background restrictions.
- Explains the setup steps and network-sharing risks.

## What it does not do
AUTOEARN is not itself a money-making network and does not generate guaranteed income. Honeygain performs bandwidth sharing inside its own app after the user signs in and starts it. AUTOEARN cannot access Honeygain's private account, force its service to run, read its balance, or withdraw money. No public integration/API is documented for these controls.

## Egypt-specific research (November 2026)
- Honeygain is the only option in this MVP aimed at passive bandwidth sharing. Honeygain says its Android app must be installed from its official website (it is not on Google Play). Earnings depend on demand and are not guaranteed.
- Honeygain payout options vary by mode and country: Honeygain mode has a $20 minimum; JumpTask mode has a $1 first payout then $0.50, with payout handled through GIFQ. Vodafone Cash is not listed as a direct method.
- Ayyam advertises payouts in Egypt to InstaPay or mobile wallets including Vodafone, but earnings are from genuine views on original videos. Ayyam's rules prohibit fake views, bots, and unapproved automated app use, so AUTOEARN must not automate views or engagement.
- GIG Egypt lists shift-based work with Vodafone Cash and other payout methods; these are real shifts, not unattended phone earnings.

## Build
GitHub Actions builds a debug APK on pushes to main and manual workflow dispatch.
