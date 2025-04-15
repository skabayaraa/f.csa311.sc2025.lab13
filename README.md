# Lab 13 - Хуулбар туршилт (Test Double) (Хуурамч (Fakes), Загвар (Stubs), болон Хуурмаг (Mocks))

Энэ дасгал нь хуулбар тесттэй танилцахад зориулагдсан болно.

## Хүлээлгэн өгөх зүйлс

- [ ] `logIn` үйлдлийн хуурамч тест
- [ ] `getRecommendation` үйлдлийн загвар тест
- [ ] `sendPromoEmail` үйлдлийн хуурмаг тест

## Товч тайлбар

Туршилтын явцад заримдаа бодит хувилбартай адилхан харагдаж, ажилладаг боловч илүү хялбаршуулсан хувилбаруудыг ашиглах шаардлага гардаг бөгөөд энэ нь нарийн төвөгтэй байдлыг бууруулж, туршилтыг хөнгөвчилдөг. Бодит орчинд зориулсан обьектууд эсвэл процедурууд хэт удаан, боломжгүй, үнэтэй, тодорхой бус, эсвэл тогтворгүй байж болно. Иймээс туршилтын хуулбаруудыг (test doubles) ихэвчлэн ашигладаг. Туршилтын хуулбаруудын олон төрөл байдаг ч хамгийн алдартай нь Хуурамч (Fakes), Загвар (Stubs), болон Хуурмаг (Mocks) юм.

### Хуурамч тест

Хуурамч (Fakes) нь хялбаршуулсан хэрэгжилттэй, бүрэн ажиллагаатай классууд юм. Ихэвчлэн тэд зарим товчлолыг ашигладаг бөгөөд бодит обьектын хялбаршуулсан хувилбар байдаг. Бид хуурамчийг туршилтын явцад хэт өндөр өртөгтэй хандах обьектуудтай, жишээлбэл мэдээллийн сантай шууд харьцахаас зайлсхийхийн тулд ашигладаг. Тиймээс бид жинхэнэ мэдээллийн сан руу хандахын оронд ижил үйлдлүүдийг дуурайлган хийх бүрэн ажиллагаатай, санах ойд ажилладаг мэдээллийн санг ашигладаг.

![Хуурамч](https://miro.medium.com/v2/resize:fit:1400/format:webp/0*snrzYwepyaPu3uC9.png)

### Загвар тест

Загвар (Stub) нь урьдчилан тохируулсан өгөгдөл буцаадаг хиймэл класс юм. Бид үүнийг туршилтын явцад дуудлагад хариу өгөхийн тулд ашигладаг. Загварыг бид жинхэнэ өгөгдлөөр хариулах обьектуудыг оруулах боломжгүй эсвэл хүсэхгүй, эсвэл хүсээгүй гаж нөлөө үзүүлж болзошгүй тохиолдолд ашигладаг. Жишээлбэл, жинхэнэ мэдээллийн сан руу хандахын оронд бид урьдчилан тодорхойлсон өгөгдөлтэй загварыг ашиглан зөвхөн шаардлагатай үйлдлийг дуурайлган хийдэг.

![Загвар](https://miro.medium.com/v2/resize:fit:1400/format:webp/0*KdpZaEVy6GNnrUpB.png)

### Хуурмаг тест

Хуурмаг (Mock) нь бодит классын нарийн хяналттай, багажлагдсан хувилбар юм. Бид хуурмагийг өндөр өртөгтэй бодит орчны кодыг дуудахыг хүсэхгүй, эсвэл тодорхой үйлдэл хийгдсэн эсэхийг шалгах энгийн арга байхгүй тохиолдолд ашигладаг. Жишээлбэл, бид имэйлийн системийг турших болгондоо шинэ имэйл илгээхийг хүсдэггүй.

![Хуурмаг](https://miro.medium.com/v2/resize:fit:1400/format:webp/0*k7mwTF60slyMxRlm.png)

Эдгээр гурван нэр томъёог практикт ихэвчлэн хольж хэрэглэдэг боловч бага зэргийн ялгаа байдаг. Хэрвээ та эдгээрийн ялгааг бүрэн ойлгоогүй хэвээр байвал (санаа зовох хэрэггүй, туршлагатай хөгжүүлэгчид ч алдаж болно), онлайнаас илүү дэлгэрэнгүй мэдээлэл өгдөг олон эх сурвалж олддог (ж.нь. https://martinfowler.com/articles/mocksArentStubs.html).

## Удирдамж

AndrewWS-ийн репозиторийг https://github.com/gobi/f.csa311.sc2025.lab13 хаягаас fork хийж clone-дож ав. Эхлэхийн тулд дараах тушаалуудыг ажиллуул:

```
mvn install
mvn test
```

Туршилтууд удаан хугацаанд ажиллаж байгааг анзаарч болно. Туршилтын хуулбаруудыг ашиглан гүйцэтгэлийг сайжруулъя! Өгөгдсөн файлуудыг шалгаж, аль төрлийн туршилтын хуулбаруудыг аль аргуудыг туршихад ашиглахыг тодорхойл. Тэндээс цааш хэрхэн үргэлжлүүлэх талаар зөвлөмжүүд олдно.

Бүх туршилтуудыг AndrewWebServicesTest.java дотор бичих ёстой. Мөн InMemoryDatabase.java дотор хуурамч мэдээллийн сан хэрэгжүүлэх шаардлагатай. Хуурмагийн хувьд бид [Mockito](https://site.mockito.org/) фреймвөркийг ашиглана.

## Mockito

Энэ лабораторид бид [Mockito](https://site.mockito.org/) хуурмагийн фреймвөркийг ашиглана. Mockito-ийн чухал хэсгүүдийг танилцуулахын тулд энгийн жишээ авъя.

Энд бид Cartoons классыг ашиглана. Cartoons класс нь хүүхэлдэйн киноны баатруудыг тэдний харьяалагддаг хүүхэлдэйн кинотой холбодог хамаарлыг илэрхийлдэг гэж үзье.

```
public class Cartoons {
	private Map<String, String> charactersToCartoons;

	public String get(String character) {
		return charactersToCartoons.get(character);
	}
}
```

`mock` методыг ашиглаж `Cartoons` классын хуурмагийг үүсгэнэ:

```
Cartoons ourMock = mock(Cartoons.class);
```

Дараа нь `when` болон `thenReturn` методуудыг ашиглаж хуурмаг класс яаж ажиллахыг зааж өгнө. (өөрөөр методын дуудалтын загварыг үүсгэнэ гэж хэлдэг):

```
when(ourMock.get("Snoopy")).thenReturn("Peanuts");
```

Ингэснээр бид `get("Snoopy")` гэж дуудах бүрт манай хуурмаг класс "Peanuts" гэж хариу буцааж ажиллах юм.

Ингэснээр, хуурмаг классаас бид метод дуудалдыг ажиллуулж чадна:

```
String snoopyCartoon = ourMock.get("Snoopy");
```

Одоо харин `verify` методын тусламжтайгаар бидний метод өгөгдсөн аргументтайгаар дуудагдсан эсэхийг шалгаж болно. Дараах мөрүүд нь `get` методыг дуудсан эсэхийг магадлаж бидний өгсөн дагууд утга буцаасан эсэхийг шалгаж байна:

```
verify(ourMock).get("Snoopy");
assertEquals(snoopyCartoon, "Peanuts")
```

Ингэснээр бид `Cartoons` классыг амжилттайгаар хуурмаг болгож `get` методын дуудалтыг нь загвар дуудалт болгон орлуулахыг үзлээ.

Энэ жишээ нь лабораторийн хуурмагийн талаар мэдэх шаардлагатай бүх зүйлийг хамарсан болно. Дээр ашигласан аргуудын талаар дэлгэрэнгүй мэдээлэл, баримт бичиг авахыг хүсвэл [Mockito website](https://site.mockito.org/)-ыг үзэж болно, эсвэл дээрх жишээ тодорхой бус байвал онлайнаас бусад Mockito-ийн жишээнүүдийг хайж болно. Мөн тусламж хэрэгтэй бол багшаасаа асуу. Амжилт хүсье!
