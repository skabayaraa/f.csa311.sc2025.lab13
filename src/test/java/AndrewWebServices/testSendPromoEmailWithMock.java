@Test
public void testSendPromoEmailWithMock() {
    // 1. Хуурмаг имэйл сервис үүсгэнэ
    EmailService mockEmailService = mock(EmailService.class);

    // 2. Имэйл илгээнэ (жишээ нь: логик функц дуудах)
    mockEmailService.sendPromoEmail("enkhsaruul@example.com");

    // 3. Тухайн имэйл хаяг руу илгээсэн эсэхийг шалгана
    verify(mockEmailService).sendPromoEmail("enkhsaruul@example.com");
}
