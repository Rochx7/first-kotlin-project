package br.com.rocha.firstkotlinproject.module

import java.time.LocalDate
import java.time.Period

data class Period(
    val initialDate: LocalDate,
    val endDate: LocalDate
){
    val inDays = Period.between(initialDate,endDate).days
}
