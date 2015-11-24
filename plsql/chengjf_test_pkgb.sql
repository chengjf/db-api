CREATE OR REPLACE PACKAGE BODY chengjf_test IS
  function apply_discountx(price in number, discount in number) return number is
  begin
    return price * discount;
  end apply_discountx;

  procedure apply_discount(price    in number,
                           discount in number,
                           result   out number) is
  begin
    select price * discount into result from dual;
  end apply_discount;
end chengjf_test;
/
