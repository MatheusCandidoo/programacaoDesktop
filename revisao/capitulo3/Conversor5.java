package programacaoDesktop.revisao.capitulo3;

public class Conversor5 {


    double celsiusParaFahrenheit(double celsius) {
        return 9 * celsius / 5 + 32;
    }

    double fahrenheitParaCelsius(double fahrenheit) {
        return 5 * (fahrenheit - 32.0) / 9;
    }

    double celsiusParaKelvin(double celsius) {
        return celsius + 273;
    }

    double kelvinParaCelsius(double kelvin) {
        return kelvin - 273;
    }

    double fahrenheitParaKelvin(double fahrenheit) {
        return celsiusParaKelvin(fahrenheitParaCelsius(fahrenheit));
    }

    double kelvinParaFahrenheit(double kelvin) {
        return celsiusParaFahrenheit(kelvinParaCelsius(kelvin));
    }

    public static void main(String[] args) {
        Conversor5 conversor = new Conversor5();
        double celsius = 5, fahrenheit = 5, kelvin = 5;

        System.out.println(conversor.celsiusParaFahrenheit(celsius));
        System.out.println(conversor.fahrenheitParaCelsius(fahrenheit));
        System.out.println(conversor.celsiusParaKelvin(celsius));
        System.out.println(conversor.kelvinParaCelsius(kelvin));
        System.out.println(conversor.fahrenheitParaKelvin(fahrenheit));
        System.out.println(conversor.kelvinParaFahrenheit(kelvin));
    }
}
