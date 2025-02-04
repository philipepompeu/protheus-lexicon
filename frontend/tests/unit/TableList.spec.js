import { mount } from "@vue/test-utils";
//import TableList from "@/components/TableList.vue";
import TableList from "../../src/components/TablesList.vue";

describe("TableList.vue", () => {
  it("renderiza corretamente", () => {
    const wrapper = mount(TableList);
    expect(wrapper.exists()).toBe(true);
  });
});
