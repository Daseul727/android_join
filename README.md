## 구성

### AndroidManifest
설정


dataBinding 사용하려면 build.gradle 설정 추가해줘야한다

```kotlin
private fun inflateView() {
        binding = IncTitlebarBinding.inflate(LayoutInflater.from(context))
    }
```
```properties
 buildFeatures {
        viewBinding true
        dataBinding true
 }
```