package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Country;
import mk.finki.ukim.eshop.model.dto.CountryDto;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();

    Country getCountryById(Long country);

    Country addCountry(CountryDto country);

    Country editCountry(Long id, CountryDto country);

    void deleteCountry(Long id);
}
