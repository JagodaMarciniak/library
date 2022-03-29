package com.example.demo.book.controller;

import com.example.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
//@RequiredArgsConstructorgeneruje konstruktor z 1 parametrem dla każdego pola, które wymaga specjalnej obsługi.
// Wszystkie niezainicjowane final pola otrzymują parametr, a także wszystkie pola oznaczone jako @NonNullniezainicjowane
// w miejscu, w którym są zadeklarowane. W przypadku pól oznaczonych @NonNull, generowane jest również jawne sprawdzenie
// wartości null. Konstruktor wyrzuci NullPointerExceptionif którykolwiek z parametrów przeznaczonych dla pól oznaczonych
// @NonNull include null. Kolejność parametrów odpowiada kolejności, w jakiej pola pojawiają się w Twojej klasie.
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BooksControler {

        private final BookService bookService;

        @GetMapping("/books")
        public ResponseEntity<List<NaborDto>> pobierzKsiazkiUzytkownika() {
            return new ResponseEntity<>(naboryService.pobierzNaboryBeneficjenta(), HttpStatus.OK);
        }

        @GetMapping("/nabory/status/aktualne")
        public ResponseEntity<List<NaborQueryDto>> pobierzAktualneNaboryDlaOperatora() {
            return new ResponseEntity<>(naboryService.pobierzAktualneNaboryOperatora(), HttpStatus.OK);
        }

        @GetMapping("/nabory/status/archiwalne")
        public ResponseEntity<List<NaborQueryDto>> pobierzArchiwalneNaboryDlaOperatora() {
            return new ResponseEntity<>(naboryService.pobierzArchiwalneNaboryOperatora(), HttpStatus.OK);
        }

        @PutMapping("/nabory/{id}")
        public ResponseEntity<NaborDto> edytujNabor(@PathVariable Long id, @Valid @RequestBody NaborDto naborDTO, BindingResult bindingResult) {
            return new ResponseEntity<>(naboryService.aktualizujNabor(id, naborDTO), HttpStatus.OK);
        }

        @PutMapping("/nabory/{id}/status/{status}")
        public ResponseEntity<NaborDto> edytujStatusNaboru(@PathVariable Long id, @PathVariable String status) {
            return new ResponseEntity<>(naboryService.aktualizujStatusNaboru(id, status), HttpStatus.OK);
        }

        @GetMapping("/nabory/{id}")
        public ResponseEntity<NaborDto> pobierzNaborPoIdentyfikatorze(@PathVariable Long id) {
            return new ResponseEntity<>(naboryService.pobierzNaborPoIdentyfikatorze(id), HttpStatus.OK);
        }

        @PostMapping("/nabory")
        public ResponseEntity<?> utworzNabor(@Valid @RequestBody NaborDto naborDTO, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(naboryService.zapiszNabor(naborDTO), HttpStatus.OK);
        }

}
