PL/SQL Developer Test script 3.0
12
-- CHENGJIANFENG100 ������ 2015-11-24 
declare
  -- �����Ǳ��ر���
  --i integer;
  v_result number;
begin
  -- �����ǲ������
  chengjf_test.apply_discount(100, 0.9, v_result);
  dbms_output.put_line(v_result);
  v_result := chengjf_test.apply_discountx(100, 0.9);
  dbms_output.put_line(v_result);
end;
0
0
