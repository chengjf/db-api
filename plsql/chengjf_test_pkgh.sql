create or replace package chengjf_test is
  procedure apply_discount(price    in number,
                           discount in number,
                           result   out number);

  function apply_discountx(price in number, discount in number) return number;
end chengjf_test;
/
