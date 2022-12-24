import enums.ColorGift;
import enums.SizeGift;
import enums.TypeGift;

//год;размер подарка;вес подарка;тип подарка;цвет упаковочной бумаги
public record Gift(int year, SizeGift size, double weight, TypeGift type, ColorGift color) {
}
