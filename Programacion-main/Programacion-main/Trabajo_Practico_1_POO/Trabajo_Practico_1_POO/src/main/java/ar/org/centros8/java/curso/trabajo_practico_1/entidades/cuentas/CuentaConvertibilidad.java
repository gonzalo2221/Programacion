package ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.ClienteEmpresa;
import lombok.Getter;

import lombok.ToString;

@Getter

@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {
    private double saldoEnDolares;
    private double precioDolar;

    public CuentaConvertibilidad(int nroDeCuenta, ClienteEmpresa clienteAsociado, double giroEnDescubierto) {
        super(nroDeCuenta, clienteAsociado, giroEnDescubierto);
        
    }
public double convertirADolares(double montoEnPeso, double precioDolar) {
        if (montoEnPeso <= getSaldo()) {
            System.out.println("Sr. Cliente la compra en dolares es solo con saldo en cuenta.");
            setSaldo(getSaldo() - montoEnPeso);
            saldoEnDolares = Math.round((saldoEnDolares + (montoEnPeso / precioDolar)) * 100.0) / 100.0;
            return saldoEnDolares;
        } else {
            System.out.println("Saldo en pesos insuficiente para realizar la operacion");
            return saldoEnDolares;
        }
    }

    /**
     * Convierte un monto de dólares a pesos, siempre y cuando el monto a convertir
     * no supere el saldo en dólares disponible.
     * 
     * @param monto -> El monto en dólares que se desea convertir a pesos.
     * @return -> El nuevo saldo en pesos después de la conversión, o el saldo en
     *         pesos sin modificar si el monto a convertir supera el saldo en
     *         dólares disponible.
     */
    public double convertirAPesos(double montoEnDolares, double precioDolar) {
        if (montoEnDolares <= saldoEnDolares) {
            saldoEnDolares -= montoEnDolares;
            setSaldo(getSaldo() + (montoEnDolares * precioDolar));
            return getSaldo();
        } else {
            System.out.println("Saldo en dolares insuficiente");
            return getSaldo();
        }
    }


    // Méto para depositar dolares
    public void depositarDolares(double monto) {
        saldoEnDolares = saldoEnDolares + monto;
    }

    // metodo extracion dolares, siempre y cuando haya saldoDolar positivo.
    public void extraerDolares(double monto) {
        if (saldoEnDolares >= monto) {
            saldoEnDolares = saldoEnDolares - monto;
        } else {
            System.out.println("Saldo en dolares Insuficiente");
        }
    }
}
