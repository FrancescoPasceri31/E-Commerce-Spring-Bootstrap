package com.myBookstoreProject.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USConstants {

	public final static String US = "US";

	public final static Map<String, String> mapOfUSStates = new HashMap<String, String>() {
		{
			put("RM", "Roma");
//			put("SCV", "Città del Vaticano");
			put("VT", "Viterbo");
			put("RI", "Rieti");
			put("FR", "Frosinone");
			put("LT", "Latina");
			put("TR", "Terni");
			put("PG", "Perugia");
			put("SS", "Sassari");
			put("OT", "Olbia-Tempio");
			put("NU", "Nuoro");
			put("OG", "Ogliastra");
			put("CA", "Cagliari");
			put("OR", "Oristano");
			put("CI", "Carbonia-Iglesias");
			put("MD/VS", "Medio Campidano");
			put("TO", "Torino");
			put("AO", "Aosta");
			put("CN", "Cuneo");
			put("VC", "Vercelli");
			put("BI", "Biella");
			put("AT", "Asti");
			put("AL", "Alessandria");
			put("GE", "Genoa");
			put("SV", "Savona");
			put("IM", "Imperia");
			put("SP", "La Spezia");
			put("MI", "Milano");
			put("MB", "Monza e Brianza");
			put("VA", "Varese");
			put("CO", "Como");
			put("SO", "Sondrio");
			put("LC", "Lecco");
			put("BG", "Bergamo");
			put("BS", "Brescia");
			put("CR", "Cremona");
			put("LO", "Lodi");
			put("PV", "Pavia");
			put("NO", "Novara");
			put("VB", "Verbano-Cusio-Ossola");
			put("PC", "Piacenza");
			put("VE", "Venezia");
			put("TV", "Treviso");
			put("BL", "Belluno");
			put("UD", "Udine");
			put("PN", "Pordenone");
			put("TS", "Trieste");
			put("GO", "Gorizia");
			put("PD", "Padova");
			put("VI", "Vicenza");
			put("VR", "Verona");
			put("TN", "Trento");
			put("BZ", "Bolzano/Bozen");
			put("BO", "Bologna");
			put("MO", "Modena");
			put("RE", "Reggio Emilia");
			put("PR", "Parma");
			put("FE", "Ferrara");
			put("RO", "Rovigo");
			put("MN", "Mantua");
			put("FC", "Forlì-Cesena");
			put("RN", "Rimini");
//			put("RSM", "Repubblica di San Marino");
			put("RA", "Ravenna");
			put("FI", "Firenze");
			put("PT", "Pistoia");
			put("AR", "Arezzo");
			put("SI", "Siena");
			put("MS", "Massa-Carrara");
			put("LU", "Lucca");
			put("PI", "Pisa");
			put("LI", "Livorno");
			put("GR", "Grosseto");
			put("PO", "Prato");
			put("AN", "Ancona");
			put("PU", "Pesaro e Urbino");
			put("MC", "Macerata");
			put("AP", "Ascoli Piceno");
			put("FM", "Fermo");
			put("TE", "Teramo");
			put("PE", "Pescara");
			put("CH", "Chieti");
			put("AQ", "L'Aquila");
			put("BA", "Bari");
			put("FG", "Foggia");
			put("BR", "Brindisi");
			put("LE", "Lecce");
			put("TA", "Taranto");
			put("MT", "Matera");
			put("BT", "Barletta-Andria-Trani");
			put("NA", "Napoli");
			put("CE", "Caserta");
			put("BN", "Benevento");
			put("AV", "Avellino");
			put("SA", "Salerno");
			put("PZ", "Potenza");
			put("CB", "Campobasso");
			put("IS", "Isernia");
			put("CS", "Cosenza");
			put("CZ", "Catanzaro");
			put("KR", "Crotone");
			put("RC", "Reggio Calabria");
			put("VV", "Vibo Valentia");
			put("PA", "Palermo");
			put("TP", "Trapani");
			put("AG", "Agrigento");
			put("CL", "Caltanissetta");
			put("EN", "Enna");
			put("CT", "Catania");
			put("SR", "Siracusa");
			put("RG", "Ragusa");
			put("ME", "Messina");

		}
	};

	public final static List<String> listOfUSStatesCode = new ArrayList<>(mapOfUSStates.keySet());
	public final static List<String> listOfUSStatesName = new ArrayList<>(mapOfUSStates.values());
}