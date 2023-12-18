package com.soyhenry.expenseapp.controller;

import com.soyhenry.expenseapp.dto.request.ExpenseRequestDto;
import com.soyhenry.expenseapp.dto.response.ExpenseResponseDto;
import com.soyhenry.expenseapp.exception.DAOException;
import com.soyhenry.expenseapp.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // El endpoint con POST envía un body definido por las propiedades del dto
    @PostMapping()
    public ResponseEntity<String> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        String response = expenseService.createExpense(expenseRequestDto);
        System.out.println("ExpenseController: creando un gasto");
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    // El endpoint con PUT envía un body definido por las propiedades del dto para actualizar el gasto con id especificado por parametro
    @PutMapping("/update")
    public ResponseEntity<String> updateExpense(@RequestParam Long id,
                                                 @RequestBody ExpenseRequestDto expenseRequestDto) {
        String response = expenseService.updateExpense(id, expenseRequestDto);
        System.out.println("ExpenseController: actualizando el gasto");
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(response);
    }

    // El endpoint DELETE eliminará un gasto con el id especificado por path
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) throws DAOException {
        expenseService.deleteExpense(id);
        System.out.println("ExpenseController: eliminando el gasto");
        return ResponseEntity
            .status(HttpStatus.GONE)
            .body("Se eliminó el gasto con id: " + id);
    }

    // El endpoint GET con id definido en path recuperará un gasto especificado
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        ExpenseResponseDto expenseResponseDto = expenseService.getExpenseById(id);
        System.out.println("ExpenseController: obteniendo el gasto con id: " + id);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(expenseResponseDto);
    }

    // El endpoint GET sin path ni parametro recuperará todos los gastos de la BD
    @GetMapping()
    public ResponseEntity<List<ExpenseResponseDto>> getExpenses() {
        List<ExpenseResponseDto> responses = expenseService.getAllExpenses();
        System.out.println("ExpenseController: obteniendo todos los gastos");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(responses);
    }
}
