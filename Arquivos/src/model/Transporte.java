package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transporte {

	private StringProperty tipoTransporte = new SimpleStringProperty("");
	private DoubleProperty distancia = new SimpleDoubleProperty(0);
	private DoubleProperty custoMensal = new SimpleDoubleProperty(0);

	public final DoubleProperty distanciaProperty() {
		return this.distancia;
	}

	public final double getDistancia() {
		return this.distanciaProperty().get();
	}

	public final void setDistancia(final double distancia) {
		this.distanciaProperty().set(distancia);
	}

	public final DoubleProperty custoMensalProperty() {
		return this.custoMensal;
	}

	public final double getCustoMensal() {
		return this.custoMensalProperty().get();
	}

	public final void setCustoMensal(final double custoMensal) {
		this.custoMensalProperty().set(custoMensal);
	}

	public final StringProperty tipoTransporteProperty() {
		return this.tipoTransporte;
	}

	public final String getTipoTransporte() {
		return this.tipoTransporteProperty().get();
	}

	public final void setTipoTransporte(final String tipoTransporte) {
		this.tipoTransporteProperty().set(tipoTransporte);
	}

}
