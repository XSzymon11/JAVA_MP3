# MP3 – dziedziczenie

Prosty projekt w Javie przygotowany na przedmiot MAS. Prezentuje różne sposoby odwzorowania dziedziczenia: overlapping, dziedziczenie abstrakcyjne, wielokrotne, dynamiczne oraz wieloaspektowe.

## Zaimplementowane konstrukcje

### Dziedziczenie overlapping

`Person` może jednocześnie pełnić rolę klienta (`Client`) i pracownika (`Employee`) albo tylko jedną z nich. Przeciążone konstruktory tworzą osobę z odpowiednim zestawem ról, a każda rola przechowuje referencję zwrotną do tej samej osoby. Metody `getClient()` i `getEmployee()` pilnują, aby nie można było użyć roli, której dana osoba nie posiada.

### Dziedziczenie abstrakcyjne i polimorfizm

Abstrakcyjna klasa `Vehicle` zawiera wspólne dane pojazdów oraz deklaruje metodę `calculateMonthlyMaintenanceCost()`. Klasy `Car` i `DeliveryTruck` dziedziczą po niej i implementują obliczanie kosztu na różne sposoby. W `Main` obiekty obu klas są przechowywane w tablicy typu `Vehicle[]`, a wywołanie `getServiceSummary()` wykorzystuje polimorfizm.

### Dziedziczenie wielokrotne

`Hovercraft` dziedziczy po abstrakcyjnej klasie `WaterVehicle` i jednocześnie implementuje interfejs `LandVehicle`. Dzięki temu jeden obiekt udostępnia zachowania pojazdu wodnego i lądowego: `sail()`, `drive()`, `calculateWaterRange(...)` oraz `calculateLandRange(...)`. Jest to zgodna z Javą realizacja dziedziczenia wielokrotnego za pomocą klasy i interfejsu.

### Dziedziczenie dynamiczne

`Soldier` przechowuje aktualną rolę przez interfejs `Role`. Implementacje `Infantryman`, `Medic` i `Engineer` zawierają właściwe dla danej roli dane i sposób obliczania skuteczności misji. Metoda `setRole(...)` pozwala zmienić specjalizację istniejącego żołnierza w czasie działania programu bez tworzenia nowego obiektu `Soldier`.

### Dziedziczenie wieloaspektowe

Polisa jest klasyfikowana niezależnie w dwóch aspektach. Pierwszy opisuje właściciela polisy: `IndividualInsurancePolicy` albo `CompanyInsurancePolicy`, obie dziedziczące po `InsurancePolicy`. Drugi opisuje wariant ochrony przez interfejs `CoverageVariant` i klasy `BasicCoverage` oraz `PremiumCoverage`. Kompozycja tych hierarchii pozwala swobodnie łączyć typ właściciela z wariantem ochrony bez tworzenia osobnej klasy dla każdej kombinacji.

## Struktura

- `Person`, `Client`, `Employee` – dziedziczenie overlapping przez rozdzielenie opcjonalnych ról,
- `Vehicle`, `Car`, `DeliveryTruck` – klasa abstrakcyjna, specjalizacje i polimorfizm,
- `WaterVehicle`, `LandVehicle`, `Hovercraft` – dziedziczenie wielokrotne z użyciem interfejsu,
- `Soldier`, `Role`, `Infantryman`, `Medic`, `Engineer` – dynamiczna zmiana roli,
- `InsurancePolicy`, `IndividualInsurancePolicy`, `CompanyInsurancePolicy`, `CoverageVariant`, `BasicCoverage`, `PremiumCoverage` – dziedziczenie wieloaspektowe,
- `Main` – przykłady użycia wszystkich konstrukcji.

## Uruchomienie

Wymagana jest Java 17 lub nowsza. Z katalogu głównego projektu w PowerShellu należy wykonać:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Program wypisuje w konsoli przykłady działania wszystkich pięciu konstrukcji: osoby z jedną lub dwiema rolami, polimorficzne obliczanie kosztów pojazdów, zachowanie poduszkowca na lądzie i wodzie, zmianę specjalizacji żołnierzy oraz składki polis tworzonych według dwóch niezależnych aspektów.
