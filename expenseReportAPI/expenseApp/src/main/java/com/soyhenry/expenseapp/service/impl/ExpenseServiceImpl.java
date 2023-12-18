package com.soyhenry.expenseapp.service.impl;

import com.soyhenry.expenseapp.domain.Expense;
import com.soyhenry.expenseapp.dto.response.ExpenseCategoryResponseDto;
import com.soyhenry.expenseapp.dto.request.ExpenseRequestDto;
import com.soyhenry.expenseapp.dto.response.ExpenseResponseDto;
import com.soyhenry.expenseapp.exception.DAOException;
import com.soyhenry.expenseapp.repository.ExpenseRepository;
import com.soyhenry.expenseapp.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public String createExpense(ExpenseRequestDto expenseRequestDto) {
        // Defino un mensaje de éxito por default
        String response = "Se registró el gasto con éxito";
        // Realizo un mapeo del DTO a una entidad para manipular hacia la BD
        Expense expense = mapDtoToExpense(expenseRequestDto);
        Integer responsesInserted = expenseRepository.insertExpense(expense);
        // Si el insert de BD no devolvió ningún registro modificado, entonces devuelvo un mensaje de error
        if (responsesInserted.equals(0)) {
            System.out.println("No se insertó ningún registro");
        }
        return response;
    }

    @Override
    public String updateExpense(Long id, ExpenseRequestDto expenseRequestDto) {
        // Defino un mensaje de éxito por default
        String response = "Se actualizó el gasto con éxito";
        Expense expense = mapDtoToExpense(expenseRequestDto);
        Integer responsesUpdated = expenseRepository.updateExpense(id, expense);
        // Si el update de BD no devolvió ningún registro actualizado, entonces devuelvo un mensaje de error
        if (responsesUpdated.equals(0)) {
            System.out.println("No se actualizó ningún registro con el id " + id);
        }
        System.out.println("Se actualiza la presentacion id: " + id);
        return response;
    }

    @Override
    public void deleteExpense(Long id) throws DAOException {
        expenseRepository.deleteExpense(id);
    }

    @Override
    public ExpenseResponseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.selectExpenseById(id);
        // En este caso, estoy ahorrando el uso de una variable temporal
        // y devolviendo directamente el resultado del método privado
        return mapExpenseToResponseDto(expense);
    }

    @Override
    public List<ExpenseResponseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.selectExpenses();

        // En este caso, estoy ahorrando el uso de una variable temporal para la lista
        // y devolviendo directamente el resultado de la llamada funcional
        // que colecciona todos los objetos de tipo respuesta, resultado del método mapper
        return expenses.stream()
            .map(this::mapExpenseToResponseDto)
            .collect(Collectors.toList());
    }

    // Método privado para mapear objetos DTO de entrada a entidad para manipular en la BD
    private Expense mapDtoToExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = new Expense();
        expense.setAmount(expenseRequestDto.getAmount());
        expense.setCategoryName(expenseRequestDto.getCategoryDto().getName());
        expense.setDate(expenseRequestDto.getDate());
        return expense;
    }

    // Método privado para mapear una entidad que sale hacia una respuesta como objeto DTO
    private ExpenseResponseDto mapExpenseToResponseDto(Expense expense) {
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
        expenseResponseDto.setAmount(expense.getAmount());

        ExpenseCategoryResponseDto categoryDto = new ExpenseCategoryResponseDto();
        categoryDto.setId(expense.getId());
        categoryDto.setName(expense.getCategoryName());

        expenseResponseDto.setCategoryDto(categoryDto);
        expenseResponseDto.setDate(expense.getDate());
        return expenseResponseDto;
    }

}
